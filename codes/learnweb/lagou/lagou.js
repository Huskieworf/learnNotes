/**
 * Created by Administrator on 2017/12/28.
 */
/* ȫ�ֱ��� */
var inter;//���ƹ��Ķ�ʱ��
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


//����ְλ������ְλ�Ƽ��л�
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

