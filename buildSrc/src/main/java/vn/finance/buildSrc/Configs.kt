package vn.finance.buildSrc

object Configs {

    object BuildModule {
        const val PROFILE_PRESENTATION = ":profile:presentation"
        const val PROFILE_BUSINESS = ":profile:business"
        const val PROFILE_API = ":profileApi"
    }

    object Profile {
        const val PRESENTATION_NAMESPACE = "vn.finance.profile.presentation"
        const val BUSINESS_NAMESPACE = "vn.finance.profile.business"
        const val API_NAMESPACE = "vn.finance.profile.api"
    }

    object Demo {
        const val NAMESPACE = "vn.finance.demo"
        const val APPLICATION_ID = "vn.finance.demo"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
    }

    object Artifact {
        const val GROUP_ID = "vn.finance.libs"
        const val ARTIFACT_PRESENTATION_ID = "feature-profile-presentation"
        const val ARTIFACT_BUSINESS_ID = "feature-profile-business"
        const val ARTIFACT_API_ID = "feature-profile-api"
        const val VERSION = "1.0.1"
    }
}
