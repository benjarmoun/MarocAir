<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 14/10/2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.31.0/dist/full.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" />
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
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);"><path d="M3.414 13.778 2 15.192l4.949 2.121 2.122 4.95 1.414-1.414-.707-3.536L13.091 14l3.61 7.704 1.339-1.339-1.19-10.123 2.828-2.829a2 2 0 1 0-2.828-2.828l-2.903 2.903L3.824 6.297 2.559 7.563l7.644 3.67-3.253 3.253-3.536-.708z"></path></svg>
                <h1 class="font-bold text-2xl">MarocAir</h1>
            </div>

        <!-- button profile -->
        <div>
            <button type="button" @click="profileOpen = !profileOpen" @click.outside="profileOpen = false"
                    class="h-9 w-9 overflow-hidden rounded-full">
                <img src="https://plchldr.co/i/40x40?bg=111111" alt="plchldr.co" />
            </button>

            <!-- dropdown profile -->
            <div class="absolute right-2 mt-1 w-48 divide-y divide-gray-200 rounded-md border border-gray-200 bg-white shadow-md"
                 x-show="profileOpen" x-transition>
                <div class="flex items-center space-x-2 p-2">
                    <img src="https://plchldr.co/i/40x40?bg=111111" alt="plchldr.co" class="h-9 w-9 rounded-full" />
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
        <aside class="flex w-1/6 flex-col space-y-2 border-r-2 border-gray-200 bg-white p-2" style="height: 90.5vh"
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

<%--            <a href="#" class="flex items-center space-x-1 rounded-md px-2 py-3 hover:bg-gray-100 hover:text-blue-600">--%>
<%--                <span class="text-2xl"><i class="bx bx-heart"></i></span>--%>
<%--                <span>My Favourite</span>--%>
<%--            </a>--%>

<%--            <a href="#" class="flex items-center space-x-1 rounded-md px-2 py-3 hover:bg-gray-100 hover:text-blue-600">--%>
<%--                <span class="text-2xl"><i class="bx bx-user"></i></span>--%>
<%--                <span>Profile</span>--%>
<%--            </a>--%>
        </aside>

    <div class="w-5/6 p-4">
        <div class="p-5 ">
            <div class="m-6 mx-auto w-full">
                <%--            <div class="col-md-10 mx-auto">--%>
                <%--                <div class="card">--%>
                <%--                    <div class="card-body bg-light">--%>
                <%--                        <div class="table-responsive">--%>
                <%--                            <div class="">--%>
                <h2></h2>
                <form class=" m-6 d-flex flex-column"  method="post" action="">
                    <div class="flex w-full justify-around">
                        <div class="flex w-full flex-col p-3">
                            <label class="mb-2 font-semibold" for="depart" >Depart</label>
                            <input type="text" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3" id="depart" name="depart" placeholder="Depart">

                            <label class="mb-2 font-semibold " for="nbr_pass">Number of passengers</label>
                            <input type="number" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3" id="nbr_pass" name="nbr_pass" min="1" value="1" />

                            <label class="mb-2 font-semibold" for="dated">Depart date</label>
                            <input type="date" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3" id="dated" name="dated" >
                        </div>
                        <div class="flex w-full flex-col p-3">
                            <label class="mb-2 font-semibold" for="arrive">Destination</label>
                            <input type="text" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3" id="arrive" name="arrive" placeholder="Arrive">

                            <div class="mt-9 mb-5" >
                                <input type="checkbox" name="round_trip" value="round_trip" id="round_trip" onchange="displayReturnDateForm()">
                                <label class="mb-2 font-semibold" for="arrive">Round-trip</label>
                            </div>
                            <div id="return_date" style="display:none;">
                                <label class="mb-2 font-semibold" for="datea">Return date</label>
                                <input type="date" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 mb-3" id="datea" name="datea">
                            </div>


                        </div>
                    </div>
                    <button class="btn  btn-active btn-primary mt-0 m-3" type="submit"> SEARCH </button>
                </form>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <%--            </div>--%>
            </div>
        </div>
        <div class="mx-11  overflow-x-auto">
            <table class="table table-compact table-zebra w-full">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Job</th>
                    <th>company</th>
                    <th>location</th>
                    <th>Last Login</th>
                    <th>Favorite Color</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>1</th>
                    <td>Cy Ganderton</td>
                    <td>Quality Control Specialist</td>
                    <td>Littel, Schaden and Vandervort</td>
                    <td>Canada</td>
                    <td>12/16/2020</td>
                    <td>Blue</td>
                </tr>
                <tr>
                    <th>2</th>
                    <td>Hart Hagerty</td>
                    <td>Desktop Support Technician</td>
                    <td>Zemlak, Daniel and Leannon</td>
                    <td>United States</td>
                    <td>12/5/2020</td>
                    <td>Purple</td>
                </tr>
                <tr>
                    <th>3</th>
                    <td>Brice Swyre</td>
                    <td>Tax Accountant</td>
                    <td>Carroll Group</td>
                    <td>China</td>
                    <td>8/15/2020</td>
                    <td>Red</td>
                </tr>
                <tr>
                    <th>4</th>
                    <td>Marjy Ferencz</td>
                    <td>Office Assistant I</td>
                    <td>Rowe-Schoen</td>
                    <td>Russia</td>
                    <td>3/25/2021</td>
                    <td>Crimson</td>
                </tr>
                <tr>
                    <th>5</th>
                    <td>Yancy Tear</td>
                    <td>Community Outreach Specialist</td>
                    <td>Wyman-Ledner</td>
                    <td>Brazil</td>
                    <td>5/22/2020</td>
                    <td>Indigo</td>
                </tr>
                <tr>
                    <th>6</th>
                    <td>Irma Vasilik</td>
                    <td>Editor</td>
                    <td>Wiza, Bins and Emard</td>
                    <td>Venezuela</td>
                    <td>12/8/2020</td>
                    <td>Purple</td>
                </tr>
                <tr>
                    <th>7</th>
                    <td>Meghann Durtnal</td>
                    <td>Staff Accountant IV</td>
                    <td>Schuster-Schimmel</td>
                    <td>Philippines</td>
                    <td>2/17/2021</td>
                    <td>Yellow</td>
                </tr>
                <tr>
                    <th>8</th>
                    <td>Sammy Seston</td>
                    <td>Accountant I</td>
                    <td>O'Hara, Welch and Keebler</td>
                    <td>Indonesia</td>
                    <td>5/23/2020</td>
                    <td>Crimson</td>
                </tr>
                <tr>
                    <th>9</th>
                    <td>Lesya Tinham</td>
                    <td>Safety Technician IV</td>
                    <td>Turner-Kuhlman</td>
                    <td>Philippines</td>
                    <td>2/21/2021</td>
                    <td>Maroon</td>
                </tr>
                <tr>
                    <th>10</th>
                    <td>Zaneta Tewkesbury</td>
                    <td>VP Marketing</td>
                    <td>Sauer LLC</td>
                    <td>Chad</td>
                    <td>6/23/2020</td>
                    <td>Green</td>
                </tr>
                <tr>
                    <th>11</th>
                    <td>Andy Tipple</td>
                    <td>Librarian</td>
                    <td>Hilpert Group</td>
                    <td>Poland</td>
                    <td>7/9/2020</td>
                    <td>Indigo</td>
                </tr>
                <tr>
                    <th>12</th>
                    <td>Sophi Biles</td>
                    <td>Recruiting Manager</td>
                    <td>Gutmann Inc</td>
                    <td>Indonesia</td>
                    <td>2/12/2021</td>
                    <td>Maroon</td>
                </tr>
                <tr>
                    <th>13</th>
                    <td>Florida Garces</td>
                    <td>Web Developer IV</td>
                    <td>Gaylord, Pacocha and Baumbach</td>
                    <td>Poland</td>
                    <td>5/31/2020</td>
                    <td>Purple</td>
                </tr>
                <tr>
                    <th>14</th>
                    <td>Maribeth Popping</td>
                    <td>Analyst Programmer</td>
                    <td>Deckow-Pouros</td>
                    <td>Portugal</td>
                    <td>4/27/2021</td>
                    <td>Aquamarine</td>
                </tr>
                <tr>
                    <th>15</th>
                    <td>Moritz Dryburgh</td>
                    <td>Dental Hygienist</td>
                    <td>Schiller, Cole and Hackett</td>
                    <td>Sri Lanka</td>
                    <td>8/8/2020</td>
                    <td>Crimson</td>
                </tr>
                <tr>
                    <th>16</th>
                    <td>Reid Semiras</td>
                    <td>Teacher</td>
                    <td>Sporer, Sipes and Rogahn</td>
                    <td>Poland</td>
                    <td>7/30/2020</td>
                    <td>Green</td>
                </tr>
                <tr>
                    <th>17</th>
                    <td>Alec Lethby</td>
                    <td>Teacher</td>
                    <td>Reichel, Glover and Hamill</td>
                    <td>China</td>
                    <td>2/28/2021</td>
                    <td>Khaki</td>
                </tr>
                <tr>
                    <th>18</th>
                    <td>Aland Wilber</td>
                    <td>Quality Control Specialist</td>
                    <td>Kshlerin, Rogahn and Swaniawski</td>
                    <td>Czech Republic</td>
                    <td>9/29/2020</td>
                    <td>Purple</td>
                </tr>
                <tr>
                    <th>19</th>
                    <td>Teddie Duerden</td>
                    <td>Staff Accountant III</td>
                    <td>Pouros, Ullrich and Windler</td>
                    <td>France</td>
                    <td>10/27/2020</td>
                    <td>Aquamarine</td>
                </tr>
                <tr>
                    <th>20</th>
                    <td>Lorelei Blackstone</td>
                    <td>Data Coordiator</td>
                    <td>Witting, Kutch and Greenfelder</td>
                    <td>Kazakhstan</td>
                    <td>6/3/2020</td>
                    <td>Red</td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Job</th>
                    <th>company</th>
                    <th>location</th>
                    <th>Last Login</th>
                    <th>Favorite Color</th>
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

        input.addEventListener('change', function() {
            if (input.checked) {
                document.getElementById("return_date").style.display = "block";
            } else {
                document.getElementById("return_date").style.display = "none";
            }
        });
    }

    displayReturnDateForm();
</script>
