<#import "parts/common.ftlh" as c>

<@c.page>
    <center>
    Регистрация
    ${message!""}
            <form action="/registration" method="post">
                <div class="d-flex justify-content-center">
                    <div class="form-group row">
                        <div class="col-sm-15">
                            <input type="text" name="username" class="form-control" placeholder="Логин в лиге"/>
                        </div>
                    </div>
                </div>
                <div class="d-flex justify-content-center">
                    <div class="form-group row">
                        <div class="col-sm-15">
                            <input type="password" name="password" class="form-control" placeholder="Пароль"/>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="d-flex justify-content-center"><button class="btn btn-primary" type="submit">Зарегистрироваться</button></div>
            </form>
    <a href="/login">у меня есть аккаунт</a>
    </center>
</@c.page>