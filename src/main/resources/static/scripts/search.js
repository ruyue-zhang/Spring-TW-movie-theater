let moviesIdArr =  window.location.search.substring(1).split('=')[1].split('&');
getSearchResult();

function getSearchResult() {
  moviesIdArr.forEach(value => {
    ajax({
      url: `v2/movie/subject?id=${value}`,
      method: "GET",
      success: function(responseText) {
        renderSearchReaults(responseText);
      },
    });
  })
}

function renderSearchReaults(data) {
  let url = data.image;
  document.getElementsByClassName('result-list')[0].innerHTML += `
  <li>
  <a href="detail.html?movieId=${data.id}">
    <div class="movie-infomation">
      <p class="title">${data.title} - ${data.originTitle}</p>
      <div class='poster' style="background-image:url(${url})"></div>
      <div class="info">
        <p>导演：${data.directors}</p>
        <p>主演：${data.casts}</p>
        <p>类型：${data.genres}</p>
        <p>制片国家/地区：${data.countries}</p>
        <p>语言：${data.language}</p>
        <p>片长：${data.durations}</p>
        <p>豆瓣评分：${data.rating}</p>
      </div>
    </div>
    </a>
  </li>`;
}

