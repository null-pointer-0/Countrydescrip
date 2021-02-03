# Countrydescrip
This project is for internship demo task purpose.
App uses a rest country api which returns countries data like languages,name,borders,population,etc.
I have used the 'region' endpoint to find data of ceratin region countries.The network call is done by retrofit and image processing or handling is done by AndroidSvg library.
I can't use glide for a svg file so I used the AndroidSvg library.I have only kept the name field inside the Language data class beacuse only the language name is concerned.
I have use the concept of 'nested recyclerView' to show the list data of borders and languages.
Also I have used the same layout for both inner recycler views as both needs a single textview to show data.
