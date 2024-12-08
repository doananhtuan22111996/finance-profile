package vn.finance.profile.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.profile.business.EMPTY_STRING
import vn.finance.profile.business.domain.model.CardModel

data class CardRaw(
    val holder: String?,
    val number: String?,
    val expires: String?,
    val cvv: String?,
    val brand: String?
) : BaseRaw() {
    override fun raw2Model(): CardModel = CardModel(
        holder = holder ?: EMPTY_STRING,
        number = number ?: EMPTY_STRING,
        expires = expires ?: EMPTY_STRING,
        cvv = cvv ?: EMPTY_STRING,
        brand = brand ?: EMPTY_STRING
    )
}
