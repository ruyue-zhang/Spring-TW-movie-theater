var movieDatas = JSON.parse(localStorage.getItem("moviedata"));


function searchByKeywords(){
  let keywords = document.getElementsByClassName("search-box")[0].value;
  if(keywords) {
    let moviesIdString = movieDatas.filter(value => value.title.indexOf(keywords) > -1).map(value => value.id).join('&');
    if(moviesIdString.length) {
      window.open(`search.html?movieId=${moviesIdString}`,"_self");
    } else {
      window.open(`notFindPage.html`,"_self");
    }
  }
}