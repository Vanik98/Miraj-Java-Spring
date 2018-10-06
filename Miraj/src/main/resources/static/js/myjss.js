function text() {
    if(document.getElementById("mytext").value==1)
    {
        if(document.getElementById("pagereserve").value=="en")
            document.getElementById("mytext").value="Your message was successfully sent";
        if(document.getElementById("pagereserve").value=="am")
            document.getElementById("mytext").value="Ձեր հաղորդագրությունը հաջողությամբ ուղարկված է";
        if(document.getElementById("pagereserve").value=="ru")
            document.getElementById("mytext").value="Ваше сообщение было успешно отправлено";
        document.getElementById("mytext").style.display="block";
    }
}
function text2() {
    if(document.getElementById("mytext2").value==1)
    {
        if(document.getElementById("pagecontacts").value=="en")
            document.getElementById("mytext2").value="Your message was sent";
        if(document.getElementById("pagecontacts").value=="am") {
            document.getElementById("mytext2").value = "Ձեր հաղորդագրությունը ուղարկված է";
        }
        if(document.getElementById("pagecontacts").value=="ru")
            document.getElementById("mytext2").value="Ваше сообщение отправлено";
        document.getElementById("mytext2").style.display="block";
    }
}
setInterval(function(){
    $("#block").load("admin #block");
}, 1000);
setInterval(function(){
    $("#block2").load("admin #block2");
}, 1000);
