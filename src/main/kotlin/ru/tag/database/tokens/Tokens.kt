package ru.tag.database.tokens

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object Tokens: Table() {
    private val id = Tokens.varchar("id",100)
    private val login = Tokens.varchar("login",25)
    private val token = Tokens.varchar("token", 100)

    fun insert(tokenDTO: TokenDTO) {
        transaction {
            Tokens.insert {
                it[id] = tokenDTO.rowId
                it[login] = tokenDTO.login
                it[token] = tokenDTO.token
            }
        }
    }

    fun fetchToken(token: String): TokenDTO? {
        return try {
            transaction {
                val tokenModel = Tokens.select { Tokens.token.eq(token) }.single()
                TokenDTO(
                    rowId = tokenModel[Tokens.id],
                    login = tokenModel[login],
                    token = tokenModel[Tokens.token]
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}