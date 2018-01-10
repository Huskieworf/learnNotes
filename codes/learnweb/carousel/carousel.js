/**
 * Created by Administrator on 2017/12/25.
 */
//加载，创建定时器并设置移动停顿
var inter;
window.onload = function () {
    var slider = document.getElementById("slider");
    var buttoms = document.getElementById("lunbo").children;//四个小圆点
    var buttomL = document.getElementById("bLeft");//左箭头
    var buttomR = document.getElementById("bRight");//右箭头
    changeColor(0);

//加载后开始移动，设置定时器
    inter = setInterval(function () {
        move(slider);
    }, 10);
}
//function move
function move(slider) {

    var left = slider.style.marginLeft;
    //这一句的作用？
    left = (left == "" ? 0 : parseInt(left));
    left--;
    slider.style.marginLeft = left + "px";
    var index = 0;
    if (left % 600 == 0) {

        index = 0 - left / 600;
        changeColor(index);
    }
    if (left == -2400) {
        left = 0;
        index = 0;
        slider.style.marginLeft = left + "px";
        changeColor(index);
    }
}
//改变lunbo对象颜色
function changeColor(index) {

    if (index < buttoms.length) {
        for (var i = 0; i < buttoms.length; i++) {
            buttoms[i].style.backgroundColor = "antiquewhite";
        }
        buttoms[index].style.backgroundColor = "#b3b3ff";

    }
    clearInterval(inter);
    //停顿2S以后就再次启动
    setTimeout(function () {
        //每次停顿都要清除一个定时器
        inter = setInterval(function () {
            move(slider);
        }, 10);
    }, 2000);
}

function trunL() {
    var temp = slider.style.marginLeft;
    var index = 0 - parseInt(temp) / 600;
    if (index < buttoms.length) {
        slider.style.marginLeft = parseInt(temp) - 600 + "px";
        index = index - 1;
        changeColor(index);

    }
}

function trunR() {
    var temp = slider.style.marginLeft;
    var index = 0 - parseInt(temp) / 600;
    if (index < buttoms.length) {
        slider.style.marginLeft = parseInt(temp) + 600 + "px";
        index = index + 1;
        changeColor(index);
    }
}

/*点击小圆点改变颜色*/

function dianChange(index) {
    slider.style.marginLeft = 0 - index * 600 + "px";
    var buttoms = document.getElementById("lunbo").children;

    changeColor(index);
}