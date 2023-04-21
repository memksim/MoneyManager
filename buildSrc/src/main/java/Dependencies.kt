object Dependencies {
    const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"

    //ui
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.MATERIAL}"

    //test
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"

    //mvi core
    const val MVI_CORE = "com.github.badoo.mvicore:mvicore:${Versions.MVI_CORE}"
    const val MVI_BINDER = "com.github.badoo.mvicore:binder:${Versions.MVI_CORE}"
    const val MVI_HELPER = "com.github.badoo.mvicore:mvicore-android:${Versions.MVI_CORE}"
    const val MVI_MODEL_WATCHER = "com.github.badoo.mvicore:mvicore-diff:${Versions.MVI_CORE}"

    //firebase
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"
    const val FIREBASE_CRASHLITICS = "com.google.firebase:firebase-analytics-ktx"

    //coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

}