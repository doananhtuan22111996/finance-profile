package vn.finance.profile.business.domain.model

import vn.core.domain.BaseModel

data class CardModel(
    val holder: String,
    val number: String,
    val expires: String,
    val cvv: String,
    val brand: String
) : BaseModel()