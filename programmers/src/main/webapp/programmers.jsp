<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.*" %>
<%@ page import="com.programmers.data.Data" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link href="/main.css" rel="stylesheet">
        <title>CODING PRACTICE</title>
    </head>
    <body>
        <header class="navbar sticky-top shadow bg-color-2nd">
            <div class="container-fluid d-flex">
                <a class="navbar-brand text-color-3rd fw-bolder col-5 m-0">1일 3문제</a>
                <form action="/one-day-three-quiz/goDate" class="d-flex col-2" method="post">
                    <input type="date" class="form-control  me-3 border-color-3rd text-color-3rd bg-color-2nd" name="date" value=<%=LocalDate.now()%>>
                    <button class="btn btn-outline-color-3rd fw-semibold" type="submit">GO!</button>
                </form>
                <ul class="nav col-5 justify-content-end">
                    <li class="nav-item">
                        <a class="navbar-brand text-color-3rd" href="/one-day-three-quiz/list">Main</a>
                    </li>
                    <li class="nav-item">
                        <a class="navbar-brand text-color-3rd" href="/one-day-three-quiz/addForm">Add</a>
                    </li>
                    <li class="nav-item">
                        <a class="navbar-brand text-color-3rd" href="https://school.programmers.co.kr/learn/">Programmers</a>
                    </li>
                    <li class="nav-item">
                        <a class="navbar-brand text-color-3rd" href="https://github.com/s12171934">Github</a>
                    </li>
                </ul>
            </div>
        </header>

        <%
            HashMap<String, ArrayList<Data>> datas = (HashMap<String, ArrayList<Data>>)request.getAttribute("datas");
            Set<String> dates = datas.keySet();
            Set<String> months = new HashSet<>();
            for(String date : dates) {
                String month = date.split("-")[0] + "-" + date.split("-")[1];
                months.add(month);
            }
            ArrayList<String> monthArr = new ArrayList<>(months);
            Collections.sort(monthArr);
        %>

        <div class="px-5 bg-color-3rd d-flex justify-content-center w-100">
            <main class="px-5 bg-color-1st w-100 pb-5 mb-5 shadow">
                <% for(String month : monthArr){ %>
                <%
                    Set<String> days = new HashSet<>();
                    for(String date : dates) {
                        String month_ = date.split("-")[0] + "-" + date.split("-")[1];
                        if(month.equals(month_)){
                            String day = date.split("-")[2];
                            days.add(day);
                        }
                    }
                    ArrayList<String> dayArr = new ArrayList<>(days);
                    Collections.sort(dayArr);
                %>
                <div class="d-flex justify-content-center mt-5 pt-5">
                    <h1 class="text-center text-color-4th fw-bolder fs-1 bg-color-5th w-25 py-4 shadow"><%=month%></h1>
                </div>
                <% for(String day : dayArr){ %>
                <%
                    String date = month + "-" + day;
                    String[] dateSplit = date.split("-");
                    int y = Integer.parseInt(dateSplit[0]);
                    int m = Integer.parseInt(dateSplit[1]);
                    int d = Integer.parseInt(dateSplit[2]);
                    int week = LocalDate.of(y,m,d).getDayOfWeek().getValue();
                    String color = "#000000";
                    if(week == 6){
                        color = "#0000FF";
                    }
                    if(week == 7){
                        color= "#FF0000";
                    }

                    ArrayList<Data> data123 = datas.get(date);
                %>
                <div class="pt-5" id=<%=date%>>
                    <table class="table table-color-5th table-hover table-borderless my-2 caption-top shadow-sm text-center">
                        <caption class="fs-2 fw-bolder ps-4" style="color: <%=color%>"><%=date%></caption>
                        <thead class="table-color-3rd">
                          <tr>
                              <th class="col-1" scope="col">순번</th>
                              <th class="col-1" scope="col">난이도</th>
                              <th class="col-4" scope="col">문제</th>
                              <th class="col-1" scope="col">해결</th>
                              <th class="col-5" scope="col"></th>
                          </tr>
                        </thead>
                        <tbody class="table-group-divider align-middle">
                        <% for(Data data : data123){ %>
                            <tr>
                                <th scope="row"><%=data.getNo()%></th>
                                <td><%=data.getLevel()%></td>
                                <td class="text-start"><a href="<%=data.getUrl()%>"><%=data.getTitle()%></a></td>
                                <td><%=data.getNow()%></td>
                                <td>
                                    <form class="navbar-brand text-color-3rd px-3 d-block" action="/one-day-three-quiz/changeNow" method="post">
                                        <input type="text" name="data-date-no" value="<%=data.getDate()%>:<%=data.getNo()%>" style="display: none">
                                        <ul class="nav py-0 w-100">
                                            <li class="nav-item col px-5">
                                                <input type="submit" value="미완료" name="now" class="btn btn-outline-danger w-100">
                                            </li>
                                            <li class="nav-item col px-5">
                                                <input type="submit" value="해결중" name="now" class="btn btn-outline-warning w-100">
                                            </li>
                                            <li class="nav-item col px-5">
                                                <input type="submit" value="완료" name="now" class="btn btn-outline-success w-100">
                                            </li>
                                        </ul>
                                    </form>
                                </td>
                            </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
                <%}}%>
            </main>
        </div>

        <footer class="py-5 bg-color-4th">
            <div class="container-fluid pb-5 text-center text-light align-top">
                <a class="navbar-brand fw-bolder">열심히 공부합시다</a>
            </div>
        </footer>
    </body>
</html>
