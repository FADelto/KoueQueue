<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand text-light">KoueQueue</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <#if name != "unknown">
                <li class="nav-item">
                    <a class="nav-link" href="/enterQueue">Встать в очередь на игру</a>
                </li>
            </#if>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/queueList">Админ-панель</a>
            </li>
            </#if>
        </ul>
        <#if name != "unknown"><div class="navbar-text mr-3">${name}</div></#if>
        <#if name != "unknown"><@l.logout/></#if>
        <#if name = "unknown"><a href="/registration"><button class="btn btn-outline-light" type="submit">Зарегистрироваться</button></a></#if>
        <#if name = "unknown"><a href="/login"><button class="btn btn-outline-light" type="submit">Войти</button></a></#if>
    </div>
</nav>