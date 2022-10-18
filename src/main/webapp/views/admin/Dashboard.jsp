<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 14/10/2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>


<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.31.0/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"/>
</head>
<body>
<!-- page -->
<main class="min-h-screen w-full bg-gray-100 text-gray-700" x-data="layout">
    <!-- header page -->
    <header class="flex w-full items-center justify-between border-b-2 border-gray-200 bg-white p-2">
        <!-- logo -->
        <div class="flex items-center space-x-2">
            <button type="button" class="text-3xl" @click="asideOpen = !asideOpen"><i class="bx bx-menu"></i></button>
        </div>
        <div class="flex items-center space-x-2">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                 style="fill: rgba(0, 0, 0, 1);">
                <path d="M3.414 13.778 2 15.192l4.949 2.121 2.122 4.95 1.414-1.414-.707-3.536L13.091 14l3.61 7.704 1.339-1.339-1.19-10.123 2.828-2.829a2 2 0 1 0-2.828-2.828l-2.903 2.903L3.824 6.297 2.559 7.563l7.644 3.67-3.253 3.253-3.536-.708z"></path>
            </svg>
            <h1 class="font-bold text-2xl">MarocAir</h1>
        </div>

        <!-- button profile -->
        <div>
            <button type="button" @click="profileOpen = !profileOpen" @click.outside="profileOpen = false"
                    class="h-9 w-9 overflow-hidden rounded-full">
                <img src="https://plchldr.co/i/40x40?bg=111111" alt="plchldr.co"/>
            </button>

            <!-- dropdown profile -->
            <div class="absolute right-2 mt-1 w-48 divide-y divide-gray-200 rounded-md border border-gray-200 bg-white shadow-md"
                 x-show="profileOpen" x-transition>
                <div class="flex items-center space-x-2 p-2">
                    <img src="https://plchldr.co/i/40x40?bg=111111" alt="plchldr.co" class="h-9 w-9 rounded-full"/>
                    <div class="font-medium">Hafiz Haziq</div>
                </div>

                <div class="flex flex-col space-y-3 p-2">
                    <a href="#" class="transition hover:text-blue-600">My Profile</a>
                    <a href="#" class="transition hover:text-blue-600">Edit Profile</a>
                    <a href="#" class="transition hover:text-blue-600">Settings</a>
                </div>

                <div class="p-2">
                    <button class="flex items-center space-x-2 transition hover:text-blue-600">
                        <svg class="h-4 w-4" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                             xmlns="http://www.w3.org/2000/svg">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1">
                            </path>
                        </svg>
                        <div>Log Out</div>
                    </button>
                </div>
            </div>
        </div>
    </header>

    <div class="flex w-full justify-center">
        <!-- aside -->
        <aside class="flex h-auto w-1/6 flex-col space-y-2 border-r-2 border-gray-200 bg-white p-2"
               x-show="asideOpen">
            <a href="#" class="flex items-center space-x-1 rounded-md px-2 py-3 hover:bg-gray-100 hover:text-blue-600">
                <span class="text-2xl"><i class="bx bx-home"></i></span>
                <span>Dashboard</span>
            </a>

            <a href="#" class="flex items-center space-x-1 rounded-md px-2 py-3 hover:bg-gray-100 hover:text-blue-600">
                <span class="text-2xl"><i class="bx bx-cart"></i></span>
                <span>Reservations</span>
            </a>

            <a href="#" class="flex items-center space-x-1 rounded-md px-2 py-3 hover:bg-gray-100 hover:text-blue-600">
                <%--                <span class="text-2xl"><i class="bx bx-shopping-bag"></i></span>--%>
                <svg class="h-6 w-6" fill="none" stroke="red" viewBox="0 0 24 24"
                     xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1">
                    </path>
                </svg>
                <span class="text-red-500 font-semibold">Log Out</span>
            </a>
        </aside>

        <div class="w-5/6 p-4">
            <div class="p-5 ">
                <div class="m-6 mx-auto w-full">
                    <h2></h2>
                    <!-- component -->
                    <c:if test="${erreur.size()!=0}">
                        <div class="bg-red-50 border-l-8 border-red-900 mb-2">
                            <div class="flex items-center">
                                <div class="p-2">
                                    <div class="flex items-center">
                                        <div class="ml-2">
                                            <svg class="h-8 w-8 text-red-900 mr-2 cursor-pointer"
                                                 xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                                 stroke="currentColor">
                                                <path stroke-linecap="round" stroke-linejoin="round"
                                                      stroke-width="2"
                                                      d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                            </svg>
                                        </div>
                                        <p class="px-6 py-4 text-red-900 font-semibold text-lg">Please corriger les
                                            erreurs
                                            suivant :
                                        </p>
                                    </div>
                                    <div class="px-16 mb-4">
                                        <c:forEach items="${erreur}" var="error">
                                            <li class="text-md font-bold text-red-500 text-sm">${error}</li>
                                        </c:forEach>
                                        <li class="text-md font-bold text-red-500 text-sm">Email field is required.</li>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <form class=" m-6 d-flex flex-column" method="post" action="add.vol">
                        <div class="flex w-full justify-around">
                            <div class="flex w-full flex-col p-3">
                                <label class="mb-2 font-semibold">Depart</label>
                                <select name="ville_dep"
                                        class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3">
                                    <option value=""></option>

                                    <c:forEach items="${villes}" var="ville">

                                        <option value="${ville.id}"> ${ville.nom}</option>
                                    </c:forEach>

                                </select>

                                <label class="mb-2 font-semibold " for="nbr_pass">nombre de place</label>
                                <input type="number"
                                       class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3"
                                       id="nbr_pass" name="nbr_place" min="1" value="1"/>

                                <label class="mb-2 font-semibold" for="dated"> Heure depart</label>
                                <input type="time"
                                       class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3"
                                       id="dated" name="heure_dep">
                            </div>

                            <div class="flex w-full flex-col p-3">
                                <label class="mb-2 font-semibold">Arriver</label>
                                <select name="ville_arr"
                                        class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3">
                                    <option value=""></option>

                                    <c:forEach items="${villes}" var="ville">

                                        <option value="${ville.id}"> ${ville.nom}</option>
                                    </c:forEach>

                                </select>
                                <label class="mb-2 font-semibold " for="nbr_pass">prix</label>
                                <input type="number"
                                       class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3"
                                       id="nbrd_pass" name="prix" min="1"/>

                                <label class="mb-2 font-semibold" for="dated"> Heure d'arriver</label>
                                <input type="time"
                                       class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3"
                                       id="heure_arr" name="heure_arr">
                            </div>

                        </div>
                        <button class="btn  btn-active btn-primary mt-0 m-3" type="submit"> Ajouter trajet</button>
                    </form>
                </div>
            </div>
            <div class="mx-11  overflow-x-auto">
                <table class="table table-compact table-zebra w-full">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Depart</th>
                        <th>Arrivé</th>
                        <th>Date de depart</th>
                        <th>Date d'arrivé</th>
                        <th>Prix</th>
                        <th>nombre de place</th>
                        <th>edit</th>
                        <th>supprimé</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${vols}" var="vols">
                        <tr>
                            <th>
                                    ${vols.id}/
                            </th>
                            <td>
                                    ${vols.nVille_dep}
                            </td>
                            <td>
                                    ${vols.nVille_arr}
                            </td>

                            <td>
                                    ${vols.date_dep}
                            </td>
                            <td>
                                    ${vols.date_arr}
                            </td>

                            <td>
                                    ${vols.prix} DH
                            </td>
                            <td>
                                    ${vols.nbr_place}
                            </td>
                            <td>
                                <a href='edit.vol& id="${vols.id}"'>Edit </a>
                            </td>
                            <td>
                                <a href="delete.vol?id=${vols.id}">Supprimer </a>
                            </td>


                        </tr>
                    </c:forEach>


                    </tbody>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Depart</th>
                        <th>Arrivé</th>
                        <th>Date de depart</th>
                        <th>Date d'arrivé</th>
                        <th>Prix</th>
                        <th>nombre de place</th>
                        <th>edit</th>
                        <th>supprimé</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>

    </div>
</main>
</body>

<script>
    document.addEventListener("alpine:init", () => {
        Alpine.data("layout", () => ({
            profileOpen: false,
            asideOpen: true,
        }));
    });
</script>
<script>
    function displayReturnDateForm() {
        var input = document.querySelector('#round_trip');
        input.addEventListener('change', function () {
            if (input.checked) {
                document.getElementById("return_date").style.display = "block";
            } else {
                document.getElementById("return_date").style.display = "none";
            }
        });
    }

    displayReturnDateForm();
</script>