/**
 * Created by Administrator on 2017/12/28.
 */
/* 全局变量 */
var inter;//控制广告的定时器
var container = document.getElementById("container");
var hot = document.getElementById("hot");
var newWork = document.getElementById("newWork");
window.onload = function () {
    inter = setInterval(function () {
        next(container);
    }, 2000);
}

function displayHeader() {
    var h = document.getElementById("headerHidden");
    h.style.display = "block";
}

function hiddenHeader() {
    var h = document.getElementById("headerHidden");
    h.style.display = "none";
}

function displaySliderHiden() {
    //var sliderBox = document.getElementsByClassName("sliderBox");
    //sliderBox.style.border="1px solid #f1f1f1";

}

function next(container) {

    var left = container.style.marginLeft;
    left = (left == "" ? 0 : parseInt(left));

    if (left == 0) {

        left = -800;
        container.style.marginLeft = left + "px";
    }
    else if (left == -800) {
        left = 0;
        container.style.marginLeft = left + "px";
    }
}


//热门职位和最新职位推荐切换
function hotJob() {
    hot.style.display = "block";
    //alert("1");
    newWork.style.display = "none";
}
function newJob() {
    newWork.style.display = "block";
    hot.style.display = "none";
    //alert("2");
}

