/**
 * Created by Administrator on 2017/12/25.
 */

//��ȡ������ǩ
var score = document.getElementById('score');
var level = document.getElementById("level");
// ��ȡ·����ͼ��ǩ
var map = document.getElementById('snake_map');
// Ϊ���������õ�ͼ�Ĵ�С,����������������
// ���ڴ洢����������(������ĸ���)
var rowNumber = 25;// ����
var columnNumber = 20;// ����;
var mapWidth = columnNumber * 20 + 'px';// ��ͼ�Ŀ�
var mapHeight = rowNumber * 20 + 'px';// ��ͼ�ĸ�
map.style.width = mapWidth;
map.style.height = mapHeight;// ���õ�ͼ���
// ����һ����ά����,������¼��ͼ�ϵ�����div��λ��
var snakeDIVPosition = [];
// ͨ��˫��forѭ����������ͼԪ��
for (var i = 0; i < rowNumber; i++) {
    // ������div
    var rowDIV = document.createElement('div');
    // ����div��ʽ
    rowDIV.className = 'row';
    // ����div��ӵ�·����ͼmap��
    map.appendChild(rowDIV);
    // ����һ���м�����,�����洢��ǰ���е�ÿ������div
    var rowArray = [];
    for (var j = 0; j < columnNumber; j++) {
        // ����ÿһ���еķ���div
        var columnDIV = document.createElement('div');
        // ����css��ʽ
        columnDIV.className = 'col';
        // ������DIV��ӵ���ǰ����
        rowDIV.appendChild(columnDIV);
        // ͬʱ��������ӵ���������
        rowArray.push(columnDIV);
    }
    // ��ǰ�ڲ�ѭ������,����������ӵ���ά������
    snakeDIVPosition.push(rowArray);
}


// ������ģ��
// ����һ��һά����,�����洢������ռ��div
var snake = [];
// �̶�������ʼ����Ϊ5��div
for (var i = 0; i < 5; i++) {
    // Ϊ�������ò�ͬ��ɫ��div
    snakeDIVPosition[0][i].className = 'col snakeHead';
    // �洢������������
    snake[i] = snakeDIVPosition[0][i];

}


// ���������������
var snakeX = 4;
var snakeY = 0;// ��ͷ����ʼλ��ƫ����
var scoreCount = 0;// ����������,�����˶��ٸ���
var levelCount = 1;//�ȼ���¼����
var eggX = 0;// ��¼�����ڵ���λ��
var eggY = 0;// ��¼�����ڵ���λ��;

var direction = 'right';// ��¼���ƶ��ķ���,��ʼΪ����
var changeDir = true;// �ж��Ƿ���Ҫ�ı��ߵ��ƶ�����
var delayTimer = null;// �ӳٶ�ʱ��

// ��Ӽ����¼�������������ı��ߵ��ƶ�����
document.onkeydown = function (event) {
    // ���ж��Ƿ���Ҫ�ı䷽��,true��ʾ��Ҫ,false��ʾ����Ҫ
    if (!changeDir) {
        return;// return�ձ�ʾֱ�ӽ�������,�������벻ִ��
    }
    // event = event || window.event;
    // Ϊ�˺������ߵ��ƶ�,��Ҫ�ж���ͷ������
    // �����������ƶ�,�㷽�����,�Ҽ�������Ҫ������Ӧ
    if (direction == 'right' && event.keyCode == 37) {
        return;// ��ֹ�¼�ִ��
    }
    if (direction == 'left' && event.keyCode == 39) {
        return;
    }
    if (direction == 'up' && event.keyCode == 40) {
        return;
    }
    if (direction == 'down' && event.keyCode == 38) {
        return;
    }
    // ����ͨ��keyCodeȷ����Ҫ�ƶ��ķ���
    switch (event.keyCode) {
        case 37:
            direction = 'left';// ����
            break;
        case 38:
            direction = 'up';// ����;
            break;
        case 39:
            direction = 'right';// ����
            break;
        case 40:
            direction = 'down';// ����
            break;
    }
    changeDir = false;
    delayTimer = setTimeout(function () {
        // �����Ƿ���Ҫ�ı䷽��
        changeDir = true;
    }, 300);
};

// ��ʼ�������ƶ��߼�
// ���ƶ�����
function snakeMove() {
    // �����������õķ�����������ͷ��λ��
    snakeDIVPosition[snakeY][snakeX].className = 'col snakeHead';
    switch (direction) {
        case 'left':
            snakeX--;
            break;
        case 'right':
            snakeX++;
            break;
        case 'up':
            snakeY--;
            break;
        case 'down':
            snakeY++;
            break;
    }
    ;

    // �ж��Ƿ���Ϸ����
    if (snakeX < 0 || snakeY < 0 || snakeX >= columnNumber || snakeY >= rowNumber) {
        alert('Game Over!!!');
        // �������ƶ��Ķ�ʱ��
        clearInterval(moveTimer);
        return;// ��ֹ�����¼�;
    }
    // ����߳Ե��Լ�,ҲҪ������Ϸ
    for (var i = 0; i < snake.length; i++) {
        // ����ʱ��ͷ�ƶ����λ����֮ǰ���ҵ�����ߵ�div��λ�ý��бȽ�,�����ͬ��˵���Ե��Լ�,��Ϸ����
        if (snake[i] == snakeDIVPosition[snakeY][snakeX]) {
            alert('Game over!!!');
            clearInterval(moveTimer);
            return;
        }
        ;
    }
    // �ж���ͷ�ƶ���λ���Ƿ��е�
    if (eggX == snakeX && eggY == snakeY) {
        snakeDIVPosition[eggY][eggX].className = 'col activeSnake';
        snake.push(snakeDIVPosition[eggY][eggX]);// ��������
        scoreCount++;// ��¼����
        // ���µ�ǰ�ķ���
        score.innerHTML = scoreCount;
        // �������һ���µĵ�
        createNewEgg();
        if (parseInt(scoreCount % 5) == 0) {
            levelCount++;
            level.innerHTML = levelCount;
            speed1 -= 20;
            clearInterval(moveTimer);
            moveTimer = setInterval('snakeMove()', speed1);
        }
    }
    else {
        // �����������������߼�
        // �����ƶ�
        // ��βȥ�����������ɫ,��ɸ��ӵ���ɫ
        snake[0].className = 'col';
        // ����βdiv���������Ƴ�
        snake.shift();
        // ��λ�����µ���ͷ���뵽��������
        snakeDIVPosition[snakeY][snakeX].className = 'col activeSnake';
        snake.push(snakeDIVPosition[snakeY][snakeX]);
    }
    ;
}
;

var moveTimer = setInterval('snakeMove()', 300);


// ����һ������min,max֮������������
function random(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}
;


function createNewEgg() {
    // ������µ�egg���±��x��yֵ
    eggX = random(0, columnNumber - 1);
    eggY = random(0, rowNumber - 1);

    // �ж������������ĵ��������غ�,�������������һ����
    if (snakeDIVPosition[eggY][eggX].className == 'col activeSnake') {
        createNewEgg();// ��������µ�egg
    } else {
        snakeDIVPosition[eggY][eggX].className = 'col egg';
    }
}
;

createNewEgg();// ����Ϸ��ʼ��ʱ�������µ�egg

var pause = document.getElementById('Pause');
var start = document.getElementById('Start');
var refresh = document.getElementById('Refresh');
var accelerate = document.getElementById('Accelerate');
// �����ͣ��ť
pause.onclick = function () {
    clearInterval(moveTimer);
};
// ��ӿ�ʼ��ť
start.onclick = function () {
    clearInterval(moveTimer);
    moveTimer = setInterval('snakeMove()', speed1);
};
// ���ˢ�°�ť
refresh.onclick = function () {
    window.location.reload();
};
// ��Ӽ��ٰ�ť
var speed1 = 300;
Accelerate.onclick = function () {
    speed1 -= 20;
    levelCount++;
    level.innerHTML = levelCount;
    clearInterval(moveTimer);
    moveTimer = setInterval('snakeMove()', speed1);

};
