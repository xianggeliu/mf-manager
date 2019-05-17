//信息弹框
/*
type:0(信息弹框),type:1(页面层弹框) ,type:2(iframe层弹框) ,type:3(加载层弹框) ,type:4(tips层弹框) 
title:['文本1','font-size:18px']
content:'传入任意的文本或html'||'http://www.baidu.com'(如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no'])||$('#dom')
buttonName:['yes', 'no'],yes: function(index, layero){
    //按钮【按钮一】的回调
  },btn2: function(index, layero){
    //按钮【按钮二】的回调
  },btn3: function(index, layero){
    //按钮【按钮三】的回调
  }
  ,cancel: function(){ 
    //右上角关闭回调
  }
options: ['500px', '300px']
shade: [0.8, '#393D49'] //遮罩层，如果不想设置则shade: 0
returns:函数名
time:3000 //3s后自动关闭
});
*/
function alert0(type,title,content,buttonName,options,shade,returns){
    layer.open({
  		type: type, 
  		title:title,
  		content:content, //这里content是一个普通的String
  		btn:buttonName,
  		area: options,
  		shade:shade,
  		yes: function(index, layero){
    layer.close(index); //如果设定了yes回调，需进行手工关闭
    returns();
  }
  		/*time:time*/
});
}
//带小图标的弹框
/*
content:'酷毙了'
style:{icon: 1, title:'提示'}
*/
function alert1(content,options,shade,time){
   layer.alert(content,options,time);
}
//带回调函数小图标的弹框
function alert2(content,options,returns,time){
    layer.confirm(content,options,
    	function(index){
  layer.close(index);returns();}
  ,time);
}
