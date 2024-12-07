package vn.finance.profile.business.data.model

import com.google.gson.annotations.SerializedName
import vn.core.data.model.BaseRaw
import vn.finance.profile.business.EMPTY_STRING
import vn.finance.profile.business.domain.model.PersonModel

data class PersonRaw(
    val name: String?,
    val email: String?,
    @SerializedName("mobile")
    val mobileNumber: String?,
    val avatar: String?
) : BaseRaw() {

    override fun raw2Model(): PersonModel =
        PersonModel(
            name = name ?: EMPTY_STRING,
            email = email ?: EMPTY_STRING,
            mobileNumber = mobileNumber ?: EMPTY_STRING,
            avatar = avatar ?: EMPTY_STRING
        )
}