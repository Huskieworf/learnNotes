/**
 * Created by Administrator on 2017/12/25.
 */
//���أ�������ʱ���������ƶ�ͣ��
var inter;
window.onload = function () {
    var slider = document.getElementById("slider");
    var buttoms = document.getElementById("lunbo").children;//�ĸ�СԲ��
    var buttomL = document.getElementById("bLeft");//���ͷ
    var buttomR = document.getElementById("bRight");//�Ҽ�ͷ
    changeColor(0);

//���غ�ʼ�ƶ������ö�ʱ��
    inter = setInterval(function () {
        move(slider);
    }, 10);
}
//function move
function move(slider) {

    var left = slider.style.marginLeft;
    //��һ������ã�
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
//�ı�lunbo������ɫ
function changeColor(index) {

    if (index < buttoms.length) {
        for (var i = 0; i < buttoms.length; i++) {
            buttoms[i].style.backgroundColor = "antiquewhite";
        }
        buttoms[index].style.backgroundColor = "#b3b3ff";

    }
    clearInterval(inter);
    //ͣ��2S�Ժ���ٴ�����
    setTimeout(function () {
        //ÿ��ͣ�ٶ�Ҫ���һ����ʱ��
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

/*���СԲ��ı���ɫ*/

function dianChange(index) {
    slider.style.marginLeft = 0 - index * 600 + "px";
    var buttoms = document.getElementById("lunbo").children;

    changeColor(index);
}