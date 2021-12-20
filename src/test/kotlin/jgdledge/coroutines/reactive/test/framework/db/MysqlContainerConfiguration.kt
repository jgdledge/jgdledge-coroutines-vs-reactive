package jgdledge.coroutines.reactive.test.framework.db

import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter
import io.micronaut.context.annotation.Requires

/**
 * Custom Bean Configuration used to configure MySQL on TestContainers in such a way that both
 * JDBC and R2DBC drivers are making use of the same Docker Container.
 */
@Requires(env = ["tc"])
@EachProperty("test.tc-mysql")
class MysqlContainerConfiguration(@param:Parameter val name: String) {
    val dockerImageName = "mysql:8"
}
