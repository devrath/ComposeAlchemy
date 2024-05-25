package com.istudio.code.modules.pagination.sample_beer_list.data.mappers

import com.istudio.code.modules.pagination.sample_beer_list.data.local.BeerEntity
import com.istudio.code.modules.pagination.sample_beer_list.data.remote.BeerDto
import com.istudio.code.modules.pagination.sample_beer_list.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}