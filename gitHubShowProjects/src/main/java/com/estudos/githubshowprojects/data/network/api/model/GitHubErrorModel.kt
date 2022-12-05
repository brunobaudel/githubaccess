package com.estudos.githubshowprojects.data.network.api.model

/**Modelo json erro Github
//{
// "message":"" ,
// "documentation_url":""
 **/
data class GitHubErrorModel(
    val message: String,
    val documentation_url: String
)