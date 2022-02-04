package com.richarddewan.hiltmvvm.util.mapper

interface Mapper<Entity, Response> {
    fun mapToEntity(response: Response): Entity
    fun mapToEntityList(reposnses: List<Response>): List<Entity>
}