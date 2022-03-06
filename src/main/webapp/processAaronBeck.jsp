<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Шкала депресси Аарона Бека</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/process" method="get">
    <lebel>Каково Ваше эмоциональное состояние?</lebel><br>
    <input type="radio" name="answer1" value="0">Я не чувствую себя расстроенным, печальным <br>
    <input type="radio" name="answer1" value="1">Я расстроен <br>
    <input type="radio" name="answer1" value="2">Я все время расстроен и не могу от этого отключиться <br>
    <input type="radio" name="answer1" value="3">Я настолько расстроен и несчастлив, что не могу это выдержать<br>
    <br><br>

    <lebel>Что вы думаете о вашем будущем?</lebel><br>
    <input type="radio" name="answer2" value="0">Я не тревожусь о своем будущем <br>
    <input type="radio" name="answer2" value="1">Я чувствую, что озадачен будущим <br>
    <input type="radio" name="answer2" value="2">Я чувствую, что меня ничего не ждет в будущем <br>
    <input type="radio" name="answer2" value="3">Мое будущее безнадежно, и ничто не может измениться к лучшему<br>
    <br><br>

    <lebel>Оцените вашу успешность</lebel><br>
    <input type="radio" name="answer3" value="0">Я не чувствую себя неудачником <br>
    <input type="radio" name="answer3" value="1">Я чувствую, что терпел больше неудач, чем другие люди <br>
    <input type="radio" name="answer3" value="2">Когда я оглядываюсь на свою жизнь, я вижу в ней много неудач <br>
    <input type="radio" name="answer3" value="3">Я чувствую, что как личность я - полный неудачник <br>
    <br><br>

    <lebel>На сколько вы удовлетворены своей жизнью?</lebel><br>
    <input type="radio" name="answer4" value="0">Я получаю столько же удовлетворения от жизни, как раньше <br>
    <input type="radio" name="answer4" value="1">Я не получаю столько же удовлетворения от жизни, как раньше <br>
    <input type="radio" name="answer4" value="2">Я больше не получаю удовлетворения ни от чего <br>
    <input type="radio" name="answer4" value="3">Я полностью не удовлетворен жизнью и мне все надоело <br>
    <br><br>

    <lebel> Как часто у вас возникает чувство вины?</lebel></b><br>
    <input type="radio" name="answer5" value="0">Я не чувствую себя в чем-нибудь виноватым <br>
    <input type="radio" name="answer5" value="1">Достаточно часто я чувствую себя виноватым <br>
    <input type="radio" name="answer5" value="2">Большую часть времени я чувствую себя виноватым <br>
    <input type="radio" name="answer5" value="3">Я постоянно испытываю чувство вины <br>
    <br><br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
