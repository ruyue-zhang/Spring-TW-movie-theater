let movieId = window.location.search.substring(1).split('=')[1];
renderPage();

function renderPage() {
  ajax({
    url: `/v2/movie/subject?id=${movieId}`,
    method: "GET",
    success: function(responseText) {
      renderMovieInfomation(responseText);
      renderSummary(responseText);
      getReviews(movieId);
      renderRecommend(responseText);
    },
  })
}

function renderMovieInfomation(data) {
  document.getElementsByClassName('title')[0].innerHTML = `${data.title} - ${data.originTitle}(${data.pubdates})`;
  let poster = document.getElementsByClassName('poster')[0];
  let url = data.image;
  poster.style.backgroundImage = `url("${url}")`;
  let info = document.getElementsByClassName("info")[0];
  info.innerHTML = `
  <p>导演：${data.directors}</p>
  <p>主演：${data.casts}</p>
  <p>类型：${data.genres}</p>
  <p>制片国家/地区：${data.countries}</p>
  <p>语言：${data.languages}</p>
  <p>片长：${data.durations}</p>
  <p>上映日期：${data.pubdates}</p>
  <p>豆瓣评分：${data.rating}</p>
  `;
}

function renderSummary(data) {
  document.getElementsByClassName("summary")[0].innerHTML += `<p>${data.summary}</p>`;
}

function getReviews(movieId) {
  ajax({
    url: `http://localhost:8080/v2/movie/reviews?movie_Id=${movieId}`,
    method: "GET",
    success: function(responseText) {
      renderFilmReview(responseText);
    }, 
  })
}

function renderFilmReview(data) {
  let content = "";
  for (let i = 0; i < 5; i++) {
    content += `
    <li>
      <img src="${data[i].avatar}" alt="#">
      <span>${data[i].title}</span>
      <p class='review-content' onclick="changeStyle(event)">${data[i].content}</p>
    </li>`;
  }
  document.getElementsByClassName("movie-comments")[0].innerHTML += content;
}

function renderRecommend(data) {
  let movieType = data.genres;
  var alldata = JSON.parse(localStorage.getItem("moviedata"));
  let RecommendMovieArr = [];
  movieType.split(",").forEach((type) => {
    alldata.forEach(item => {
      if (item.genres.indexOf(type) > -1 && item.id !== data.id) {
        RecommendMovieArr.push(item);
      }
    });
  });
  RecommendMovieArr = RecommendMovieArr.splice(0,5);
  showRecommendMovies(RecommendMovieArr);
}

function showRecommendMovies(data) {
  let recommendList = document.getElementsByClassName("recommend-movies")[0];

  for (let index = 0; index < data.length; ++index) {
    recommendList.innerHTML += `
    <a href="detail.html?keywords=${data[index].id}"></a>
    <div class="recommend-item">
     <img src="${data[index].image}"  class="recommend-covers">
     <a href="detail.html?keywords=${data[index].id}">${data[index].title}/${data[index].year}</a>
     <p>分类：${data[index].genres}</p>
     <p>评分：${data[index].rating}/10</p>
    </div>
    `;
  }
}

function changeStyle(event) {
  event.target.classList.toggle("review-content-1");
}
