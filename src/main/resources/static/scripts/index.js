let movieDatas = [];
window.onload =function() {
  getAllData();
};
function getAllData() {
  const LANDING_URL = "http://localhost:8080/v2/movie/top250";
  ajax({
    url: LANDING_URL,
    method: "GET",
    success: function(responseText) {
      mainPage(responseText);
    },
  })
}

function mainPage(data) {
  var str = JSON.stringify(data)
  localStorage.setItem("moviedata",str);
  getGenres(data);
  addMoviesInfo(data);
}

function getGenres(data) {
  movieDatas = data;
  let tempArr = [];
  let genArr = [];
  for(index = 0; index < data.length; ++index) {
    tempArr.push(data[index].genres);
  }
  tempArr.forEach((tItem) => {
    tItem.split(",").forEach((innerItem) => {
      genArr.push(innerItem);
    });
  })
  sortGenres(genArr);
}

function sortGenres(data) {
  let tempArr = data.sort();
  let resArr = [];
  for (let index = 0; index < data.length; ++index) {
    if(tempArr[index] === tempArr[index+1]) {
      continue;
    } else {
      resArr.push(tempArr[index]);
    }
  }
  addResList(resArr);
}

function addResList(res) {
  let typeList = document.getElementsByClassName("type-list")[0];
  typeList.innerHTML = `
    <li class="movie-type" id="全部">全部</li>
  `;
  for (let index = 0; index < res.length; ++index) {
    typeList.innerHTML += `
    <li class="movie-type" id="${res[index]}">${res[index]}</li>
    `;
  }
  typeList.addEventListener("click",function(event) {
    filterMovies(event.target.id);
  })
}

function filterMovies(resId) {
  let filterArr = [];
  movieDatas.forEach((item) => {
    if(item.genres.indexOf(resId) > -1) {
      filterArr.push(item);
    }
  })
  if(resId === '全部') {
    filterArr = movieDatas;
  }
  changeChecked(resId);
  addMoviesInfo(filterArr);
}

function changeChecked(resId) {
  let typeList = document.getElementsByClassName("movie-type");
  let checkedGen = document.getElementById(resId);
  for (let index = 0; index < typeList.length; ++index) {
    typeList[index].style.color = 'black';
  }
  checkedGen.style.color = 'rgb(253, 112, 18)';
}

let movieList = document.getElementsByClassName("movie-list")[0];

function addMoviesInfo(data) {
  movieList.innerHTML = '';
  for(let rowCount = 0; rowCount < (data.length / 4); ++rowCount) {
    let movieRow = document.createElement("tr");
    movieRow.setAttribute("class","movie-row");
    for(let colCount = 0; colCount < 4; ++colCount) {
      if(rowCount * 4 + colCount === 100 || data.length <= colCount + rowCount * 4) {
        break;
      }
      let index = rowCount * 4 + colCount;
      movieRow.innerHTML +=  `
          <td class='movie-info'>
            <a href="detail.html?keywords=${data[index].id}">
              <img class='movie-cover' src="${data[index].image}">
            </a>
            <div class = 'movie-infos'>
                <a class='infos' href="detail.html?keywords=${data[index].id}">${data[index].title}/${data[index].year}</a>
                <span class='infos'>导演：${data[index].directors}</span>
                <span class='infos'>主演：${data[index].casts}</span>
                <span class='infos'>时长：${data[index].durations}</span>
                <span class='infos'>分类：${data[index].genres}</span>
                <span class='movie-rate'>评分：${data[index].rating}/10</span>
            </div>
          </td>
        `;
    }
    movieList.appendChild(movieRow);
  }
}

function searchByKeywords(){
  let keywords = document.getElementsByClassName('search-box')[0].value;
  if(keywords) {
    let moviesIdString = movieDatas.filter(value => value.title.indexOf(keywords) > -1).map(value => value.id).join('&');
    if(moviesIdString.length) {
      window.open(`search.html?movieId=${moviesIdString}`,"_self");
    } else {
      window.open(`notFindPage.html`,"_self");
    }
  }
}