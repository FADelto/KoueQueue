<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <form action="/queueList" method="post">
    <h1>Очередь</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Никнейм в Лиге</th>
                    <th>Количество сыгранных игр</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list queueList as queue>
                    <tr>
                        <td>${queue.username}</td>
                        <td> ${queue.timePlayed} </td>
                        <td><a href="/queueList/${queue.id}" class="btn btn-primary" type="submit" role="button">Взять в игру</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <br>
        <br>
        <td><a href="/queueList/reset" class="btn btn-danger" type="submit" role="button">Сбросить</a></td>
        <br>
        <br>
        <h1>Игры</h1>
        <table class="table">
            <thead>
            <tr>
                <th>Время начала сбора на игру</th>
                <th>Первый игрок</th>
                <th>Второй игрок</th>
                <th>Третий игрок</th>
                <th>Четвертый игрок</th>

            </tr>
            </thead>
            <tbody>
                <#list activeGameList as activeGame >
                    <tr>
                        <th> ${activeGame.time}</th>
                        <th>${activeGame.firstPlayer}</th>
                        <th><#if !(activeGame.secondPlayer == "null")>${activeGame.secondPlayer}</#if></th>
                        <th><#if !(activeGame.thirdPlayer == "null")>${activeGame.thirdPlayer}</#if></th>
                        <th><#if !(activeGame.fourthPlayer == "null")>${activeGame.fourthPlayer}</#if></th>
                    </tr>
                </#list>
            </tbody>
        </table>
    </form>
</@c.page>