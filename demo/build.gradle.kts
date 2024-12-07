import vn.finance.buildSrc.Configs

plugins {
    vn.core.plugins.androidApplication
}

android {
    namespace = Configs.Demo.NAMESPACE
    defaultConfig {
        applicationId = Configs.Demo.APPLICATION_ID
        versionCode = Configs.Demo.VERSION_CODE
        versionName = Configs.Demo.VERSION_NAME
    }
}

dependencies {
    implementation(project(Configs.BuildModule.PROFILE_PRESENTATION))
    implementation(project(Configs.BuildModule.PROFILE_BUSINESS))
    implementation(project(Configs.BuildModule.PROFILE_API))

    implementation(libs.financeTheme)
    implementation(libs.financeLaunch)
}
