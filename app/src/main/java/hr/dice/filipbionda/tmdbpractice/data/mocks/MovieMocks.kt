package hr.dice.filipbionda.tmdbpractice.data.mocks

import hr.dice.filipbionda.tmdbpractice.data.models.Actor
import hr.dice.filipbionda.tmdbpractice.data.models.MediaItem

val mockMovies = listOf(
    MediaItem(
        title = "Inception",
        rating = 87,
        coverPath = "https://im.jdmagicbox.com/comp/jd_social/news/2021dec11/image-1092864-84qgkwd5wz.jpg?clr=#382e38",
        date = "21/07/2022",
        language = "EN",
        overview = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
        actors = listOf(
            Actor(name = "Leonardo", surname = "DiCaprio", imagePath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8yhDDv3b5ixR0-eeKOz9sfth6qlJxUFRuMk3fRJktRUVlO4fJ"),
            Actor(name = "Joseph", surname = "Gordon-Levitt", imagePath = "https://m.media-amazon.com/images/M/MV5BMTY3NTk0NDI3Ml5BMl5BanBnXkFtZTgwNDA3NjY0MjE@._V1_.jpg"),
            Actor(name = "Ellen", surname = "Page", imagePath = "https://resizing.flixster.com/VsatQP6O9THxjHuKRsWwXjtPBAg=/fit-in/352x330/v2/http://media.baselineresearch.com/images/1260564/1260564_full.jpg")
        ),
        categories = listOf("Action", "Sci-Fi", "Thriller"),
        duration = 140,
        seasons = null,
        trailerUrl = ""
    ),
    MediaItem(
        title = "The Matrix",
        rating = 88,
        coverPath = "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg",
        date = "31/03/1999",
        language = "EN",
        overview = "A computer hacker learns about the true nature of reality and his role in the war against its controllers.",
        actors = listOf(
            Actor(name = "Keanu", surname = "Reeves", imagePath = "https://m.media-amazon.com/images/M/MV5BMTk1MDQ2NTQ5OV5BMl5BanBnXkFtZTcwNzYzNjk5Mg@@._V1_.jpg"),
            Actor(name = "Laurence", surname = "Fishburne", imagePath = "https://m.media-amazon.com/images/M/MV5BMTY4ODQ1NTU1Ml5BMl5BanBnXkFtZTcwNzE2Njg2OQ@@._V1_.jpg"),
            Actor(name = "Carrie-Anne", surname = "Moss", imagePath = "https://m.media-amazon.com/images/M/MV5BMTM3NDA0MzMyOF5BMl5BanBnXkFtZTcwNjI3MDcxNw@@._V1_.jpg")
        ),
        categories = listOf("Action", "Sci-Fi"),
        duration = 136,
        seasons = null,
        trailerUrl = ""
    ),
    MediaItem(
        title = "Interstellar",
        rating = 91,
        coverPath = "https://m.media-amazon.com/images/M/MV5BNTc0YmQxMjEtODI5MC00NjFiLTlkMWUtOGQ5NjFmYWUyZGJhXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
        date = "07/11/2014",
        language = "EN",
        overview = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        actors = listOf(
            Actor(name = "Matthew", surname = "McConaughey", imagePath = "https://m.media-amazon.com/images/M/MV5BMTU4ODU5MzU4Nl5BMl5BanBnXkFtZTgwNjA5OTc2MDE@._V1_.jpg"),
            Actor(name = "Anne", surname = "Hathaway", imagePath = "https://m.media-amazon.com/images/M/MV5BMjE2MjQxOTMyOF5BMl5BanBnXkFtZTgwMjU0NDk4MjE@._V1_.jpg"),
            Actor(name = "Jessica", surname = "Chastain", imagePath = "https://m.media-amazon.com/images/M/MV5BMTMxODU3NjM0MV5BMl5BanBnXkFtZTcwNDA3NjY0OQ@@._V1_.jpg")
        ),
        categories = listOf("Adventure", "Drama", "Sci-Fi"),
        duration = 169,
        seasons = null,
        trailerUrl = ""
    ),
    MediaItem(
        title = "Fight Club",
        rating = 79,
        coverPath = "https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg",
        date = "15/10/1999",
        language = "EN",
        overview = "An insomniac office worker and a soap maker form an underground fight club that evolves into much more.",
        actors = listOf(
            Actor(name = "Brad", surname = "Pitt", imagePath = "https://m.media-amazon.com/images/M/MV5BMTE4MDA4NzQ4ODJeQTJeQWpwZ15BbWU4MDc5NjA5NjU2._V1_.jpg"),
            Actor(name = "Edward", surname = "Norton", imagePath = "https://m.media-amazon.com/images/M/MV5BMTAxOTcxODAzMDBeQTJeQWpwZ15BbWU3MDcyNDU1Mzg@._V1_.jpg")
        ),
        categories = listOf("Drama", "Thriller"),
        duration = 139,
        seasons = null,
        trailerUrl = ""
    ),
)
