package jgdledge.coroutines.reactive.data.repository

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jgdledge.coroutines.reactive.data.entity.Account
import jgdledge.coroutines.reactive.test.AccountCounter
import org.junit.jupiter.api.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import org.junit.Ignore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import java.time.Duration
import java.time.Instant
import java.util.UUID
import kotlin.math.min

@MicronautTest(environments = ["tc"])
class AccountRepositoryCoroutineTest(
    private val accountRepository: AccountRepositoryCoroutine,
    private val accountCounter: AccountCounter
) {

    @Test
    fun testItWorks() = runBlocking {
        val id = UUID.randomUUID()
        assertNull(accountRepository.findById(id))
        accountRepository.save(Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live"))
        assertNotNull(accountRepository.findById(id))
    }

    /*
    Synchronous (avg = 57.4366032s):
    58.759952
    52.170093
    47.857227
    52.250477
    65.35575
    59.854762
    61.955779
    61.566833
    57.967763
    56.627396
     */
    @Test
    @Ignore
    fun `test create 5000 accounts synchronously`() = runBlocking {
        val numAccounts = 5000
        synchronouslyCreateAccountTest(numAccounts)
        assertEquals(numAccounts, accountCounter.numAccounts)
    }

    private suspend fun synchronouslyCreateAccountTest(numAccounts: Int) {
        val start = Instant.now()
        for (i in 0 until numAccounts) {
            val id = UUID.randomUUID()
            accountRepository.save(Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live"))
        }
        val end = Instant.now()
        val timeBetween = Duration.between(start, end)
        println("Kotlin Coroutine runtime (in series): $timeBetween")
    }

    /*
    Static (avg = 9.639118s):
    10.397979
    8.153631
    9.893547
    10.397979
    8.153631
    9.893547
    10.254763
    8.760712
    8.565453
    11.919938
     */
    @Test
    @Ignore
    fun `test create 5000 accounts static batched`() = runBlocking {
        val numAccounts = 5000
        staticBatchedCreateAccountTest(numAccounts)
        assertEquals(numAccounts, accountCounter.numAccounts)
    }

    private suspend fun staticBatchedCreateAccountTest(numAccounts: Int) {
        val start = Instant.now()
        createAccountsPooled(numAccounts)
        val end = Instant.now()
        val timeBetween = Duration.between(start, end)
        println("Kotlin Coroutine runtime (static batched): $timeBetween")
    }

    private suspend fun createAccountsPooled(numAccounts: Int) = coroutineScope {
        var accountsCreated = 0
        while (accountsCreated < numAccounts) {
            val accountsToCreate = min(numAccounts - accountsCreated, BATCH_SIZE)
            val jobs = mutableListOf<Job>()
            for (i in 0 until accountsToCreate) {
                jobs.add(launch(Dispatchers.IO) {
                    val id = UUID.randomUUID()
                    accountRepository.save(Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live"))
                })
            }
            jobs.joinAll()
            accountsCreated += accountsToCreate
        }
    }

    /*
    Dynamic (avg = 9.1258405s):
    9.488685
    7.69979
    9.329353
    7.726274
    9.889788
    8.207901
    10.576024
    7.898066
    12.034038
    8.408486
     */
    @Test
    @Ignore
    fun `test create 5000 accounts dynamic batched`() = runBlocking {
        val numAccounts = 5000
        dynamicBatchedCreateAccountTest(numAccounts)
        assertEquals(numAccounts, accountCounter.numAccounts)
    }

    private suspend fun dynamicBatchedCreateAccountTest(numAccounts: Int) {
        val start = Instant.now()
        createAccountsDynamic(numAccounts)
        val end = Instant.now()
        val timeBetween = Duration.between(start, end)
        println("Kotlin Coroutine runtime (dynamic batched): $timeBetween")
    }

    private suspend fun createAccountsDynamic(numAccounts: Int): Unit = coroutineScope {
        val jobs = mutableListOf<Job>()
        var accountsCreated = 0
        while (accountsCreated < numAccounts) {
            if (jobs.size < BATCH_SIZE) {
                jobs.add(launch(Dispatchers.IO) {
                    val id = UUID.randomUUID()
                    accountRepository.save(Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live"))
                })
                accountsCreated++
            } else {
                yield()
                jobs.retainAll { it.isActive }
            }
        }
    }


    companion object {
        private const val BATCH_SIZE = 100
    }
}
