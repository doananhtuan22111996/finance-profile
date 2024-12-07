package vn.finance.profile.business

import retrofit2.Response
import retrofit2.http.GET
import vn.core.data.model.ObjectResponse
import vn.finance.profile.business.data.model.PersonRaw

interface ProfileApiService {

    @GET("/profile")
    suspend fun getProfile(): Response<ObjectResponse<PersonRaw>>
}