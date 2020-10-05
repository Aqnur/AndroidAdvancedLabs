 ApplicationMVVM/app/build.gradle                   |  32 [32m++[m[31m--[m
 .../applicationmvvm/model/api/RetrofitService.kt   |  49 [32m+++++[m[31m-[m
 .../example/applicationmvvm/model/json/Pokemon.kt  |  12 [32m+[m[31m-[m
 .../model/repository/PokemonRepository.kt          |   2 [32m+[m[31m-[m
 .../applicationmvvm/view/PokemonListAdapter.kt     |  33 [32m+[m[31m---[m
 .../applicationmvvm/view/PokemonListFragment.kt    |  13 [32m+[m[31m-[m
 .../applicationmvvm/view/PokemonListViewHolder.kt  |  24 [32m+++[m
 .../app/src/main/res/layout/activity_main.xml      |  19 [32m++[m[31m-[m
 .../{list_item.xml => pokemon_list_item.xml}       |  22 [32m+[m[31m--[m
 ...main_nav_fragment.xml => pokemons_fragment.xml} |   0
 MVVMapplication/.gitignore                         |  14 [32m++[m
 MVVMapplication/app/.gitignore                     |   1 [32m+[m
 MVVMapplication/app/build.gradle                   |  37 [32m+++++[m
 MVVMapplication/app/proguard-rules.pro             |  21 [32m+++[m
 .../applicationmvvm/ExampleInstrumentedTest.kt     |  24 [32m+++[m
 MVVMapplication/app/src/main/AndroidManifest.xml   |  21 [32m+++[m
 .../com/example/mvvmapplication/MainActivity.kt    |  11 [32m++[m
 .../res/drawable-v24/ic_launcher_foreground.xml    |  30 [32m++++[m
 .../main/res/drawable/ic_launcher_background.xml   | 170 [32m++++++++++++++++++++[m
 .../app/src/main/res/layout/activity_main.xml      |  18 [32m+++[m
 .../src/main/res/mipmap-anydpi-v26/ic_launcher.xml |   5 [32m+[m
 .../res/mipmap-anydpi-v26/ic_launcher_round.xml    |   5 [32m+[m
 .../app/src/main/res/mipmap-hdpi/ic_launcher.png   | Bin [31m0[m -> [32m3593[m bytes
 .../src/main/res/mipmap-hdpi/ic_launcher_round.png | Bin [31m0[m -> [32m5339[m bytes
 .../app/src/main/res/mipmap-mdpi/ic_launcher.png   | Bin [31m0[m -> [32m2636[m bytes
 .../src/main/res/mipmap-mdpi/ic_launcher_round.png | Bin [31m0[m -> [32m3388[m bytes
 .../app/src/main/res/mipmap-xhdpi/ic_launcher.png  | Bin [31m0[m -> [32m4926[m bytes
 .../main/res/mipmap-xhdpi/ic_launcher_round.png    | Bin [31m0[m -> [32m7472[m bytes
 .../app/src/main/res/mipmap-xxhdpi/ic_launcher.png | Bin [31m0[m -> [32m7909[m bytes
 .../main/res/mipmap-xxhdpi/ic_launcher_round.png   | Bin [31m0[m -> [32m11873[m bytes
 .../src/main/res/mipmap-xxxhdpi/ic_launcher.png    | Bin [31m0[m -> [32m10652[m bytes
 .../main/res/mipmap-xxxhdpi/ic_launcher_round.png  | Bin [31m0[m -> [32m16570[m bytes
 MVVMapplication/app/src/main/res/values/colors.xml |   6 [32m+[m
 .../app/src/main/res/values/strings.xml            |   3 [32m+[m
 MVVMapplication/app/src/main/res/values/styles.xml |  10 [32m++[m
 .../com/example/applicationmvvm/ExampleUnitTest.kt |  17 [32m++[m
 MVVMapplication/build.gradle                       |  26 [32m++++[m
 MVVMapplication/gradle.properties                  |  21 [32m+++[m
 MVVMapplication/gradle/wrapper/gradle-wrapper.jar  | Bin [31m0[m -> [32m54329[m bytes
 .../gradle/wrapper/gradle-wrapper.properties       |   6 [32m+[m
 MVVMapplication/gradlew                            | 172 [32m+++++++++++++++++++++[m
 MVVMapplication/gradlew.bat                        |  84 [32m++++++++++[m
 MVVMapplication/settings.gradle                    |   2 [32m+[m
 43 files changed, 826 insertions(+), 84 deletions(-)
