package jgdledge.coroutines.reactive.test.framework.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import dev.miku.r2dbc.mysql.constant.SslMode
import io.micronaut.context.annotation.EachBean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Replaces
import io.micronaut.context.annotation.Requires
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import mu.KotlinLogging
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.MySQLR2DBCDatabaseContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import javax.sql.DataSource


private val log = KotlinLogging.logger {}

/**
 * Factory to define Beans for:
 *
 *  * TestContainer using MySQL image
 *  * JDBC DataSource connected to the above container
 *  * R2DBC ConnectionFactoryOptions for the above container
 *
 */
@Factory
@Requires(env = ["tc"])
class MySqlContainerFactory {

    @EachBean(MysqlContainerConfiguration::class)
    fun createTestContainer(configuration: MysqlContainerConfiguration): MySQLContainer<*> {
        val container: MySQLContainer<*> = SpecifiedMySQLContainer(configuration.dockerImageName)
            .withDatabaseName(configuration.name)
            .withLogConsumer(Slf4jLogConsumer(log))
            .withReuse(true)
        container.start()
        return container
    }

    @EachBean(MysqlContainerConfiguration::class)
    fun createJdbcDataSource(container: MySQLContainer<*>, configuration: MysqlContainerConfiguration?): DataSource {
        return getDataSource(container)
    }

    @EachBean(MysqlContainerConfiguration::class)
    @Replaces(bean = ConnectionFactoryOptions::class)
    fun createR2dbcOptions(
        container: MySQLContainer<*>?,
        configuration: MysqlContainerConfiguration?
    ): ConnectionFactoryOptions {
        return MySQLR2DBCDatabaseContainer.getOptions(container)
    }

    // OLD
//    @EachBean(ConnectionFactoryOptions::class)
//    @Replaces(bean = ConnectionFactory::class)
//    fun createR2dbcConnectionFactory(options: ConnectionFactoryOptions): ConnectionFactory {
//        val mysqlBuilder = MySqlConnectionConfiguration.builder()
//            .host(options.getRequiredValue(ConnectionFactoryOptions.HOST))
//            .port(options.getRequiredValue(ConnectionFactoryOptions.PORT))
//            .user(options.getRequiredValue(ConnectionFactoryOptions.USER))
//            .password(options.getRequiredValue(ConnectionFactoryOptions.PASSWORD))
//            .database(options.getRequiredValue(ConnectionFactoryOptions.DATABASE))
//            .sslMode(SslMode.DISABLED)
//        return MySqlConnectionFactory.from(mysqlBuilder.build())
//    }


    @EachBean(ConnectionFactoryOptions::class)
    @Replaces(bean = ConnectionFactory::class)
    fun createR2dbcConnectionFactory(options: ConnectionFactoryOptions): ConnectionFactory {
        val mysqlBuilder = MySqlConnectionConfiguration.builder()
            .host(options.getRequiredValue(ConnectionFactoryOptions.HOST).toString())
            .port(options.getRequiredValue(ConnectionFactoryOptions.PORT).toString().toInt())
            .user(options.getRequiredValue(ConnectionFactoryOptions.USER).toString())
            .password(options.getRequiredValue(ConnectionFactoryOptions.PASSWORD).toString())
            .database(options.getRequiredValue(ConnectionFactoryOptions.DATABASE).toString())
            .sslMode(SslMode.DISABLED)
        return MySqlConnectionFactory.from(mysqlBuilder.build())
//        val connectionFactory: ConnectionFactory = ConnectionFactories.get(
//            ConnectionFactoryOptions.builder()
//                .option(ConnectionFactoryOptions.DRIVER, "pools")
//                .option(ConnectionFactoryOptions.HOST, options.getRequiredValue(ConnectionFactoryOptions.HOST).toString())
//                .option(ConnectionFactoryOptions.PORT, options.getRequiredValue(ConnectionFactoryOptions.PORT).toString().toInt())
//                .option(ConnectionFactoryOptions.USER, options.getRequiredValue(ConnectionFactoryOptions.USER).toString())
//                .option(ConnectionFactoryOptions.PASSWORD, options.getRequiredValue(ConnectionFactoryOptions.PASSWORD).toString())
//                .option(ConnectionFactoryOptions.DATABASE, options.getRequiredValue(ConnectionFactoryOptions.DATABASE).toString())
//                .build()
//        )
//        return connectionFactory
    }

    protected fun getDataSource(container: JdbcDatabaseContainer<*>): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = container.jdbcUrl
        hikariConfig.username = container.username
        hikariConfig.password = container.password
        hikariConfig.driverClassName = container.driverClassName
        return HikariDataSource(hikariConfig)
    }

    // This exists as a workaround to Kotlin breaking with type SELF
    internal class SpecifiedMySQLContainer(image: String) : MySQLContainer<SpecifiedMySQLContainer>(image)
}
