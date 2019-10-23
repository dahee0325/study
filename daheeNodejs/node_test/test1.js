//events 모듈 사용
var events = require('events');

// EventEmitter 객체 생성
var EventEmitter = new events.EventEmitter();

// EventHandler 함수 생성
var connectHandler = function connected(){

    console.log("Connection Successful");

    //data_recevied 이벤트 발생시키기
    EventEmitter.emit("data_receivd");
}

EventEmitter.on('connection', connectHandler);

EventEmitter.on('data_receivd', function() {
    console.log("Data Received");
});

EventEmitter.emit('connection');

console.log("Program has ended");