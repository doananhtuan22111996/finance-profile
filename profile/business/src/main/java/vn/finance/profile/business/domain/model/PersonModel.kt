package vn.finance.profile.business.domain.model

import vn.core.domain.BaseModel

data class PersonModel(
    val name: String,
    val email: String,
    val mobileNumber: String,
    val avatar: String
) : BaseModel()