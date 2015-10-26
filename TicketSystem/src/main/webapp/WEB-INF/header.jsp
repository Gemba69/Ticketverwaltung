<nav class="blue top-nav">
    <div class="container">
        <div class="nav-wrapper">
            <a class="page-title">${param.title}</a> 
        </div>
    </div>
    <div class="container">
        <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
    </div>
    <ul id="slide-out" class="side-nav fixed">
        <li class="logo"><a id="logo-container" href="/TicketSystem/home" class="brand-logo">Logo</a></li>
        <!--<li><a class="waves-effect waves-light" href="#!"><i class="material-icons">account_circle</i>${param.username}</a></li>-->
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <li>
                    <a class="collapsible-header waves-effect waves-teal active">Tickets<i class="mdi-navigation-arrow-drop-down"></i></a>
                    <div class="collapsible-body">
                        <ul>
                            <li><a class="waves-effect waves-light" href="home?view=mine">Meine Tickets</a></li>
                            <li><a class="waves-effect waves-light" href="home?view=all">Alle Tickets</a></li>
                            <li><a class="waves-effect waves-light" href="home?view=open">Offene Tickets</a></li>
                            <li><a class="waves-effect waves-light" href="home?view=close">Geschlossene Tickets</a></li>
                            <li><a class="waves-effect waves-light" href="home?view=inwork">In Bearbeitung</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <li>
                    <a href="home?view=projects" class="waves-effect waves-teal active">Projekte</a>
                </li>
            </ul>
        </li>
        <li><a class="waves-effect waves-light red-text" href="logout"><i class="material-icons left">input</i>Logout</a></li>
    </ul>
</ul>
</nav>