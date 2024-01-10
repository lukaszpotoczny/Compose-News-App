package com.example.composenewsapp.presentation.navgraph

sealed class Route(val route: String) {

    object OnBoardingScreen: Route("onBoarding")
    object HomeScreen: Route("home")
    object SearchScreen: Route("search")
    object BookmarkScreen: Route("bookmark")
    object DetailsScreen: Route("details")
    object AppStartNavigation: Route("appStartNav")
    object NewsNavigation: Route("newsNav")
    object NewsNavigatorScreen: Route("newsNavScreen")

}
