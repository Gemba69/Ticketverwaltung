<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
    <a class="btn-floating btn-large blue">
        <i class="large material-icons">add</i>
    </a>
    <ul>
        <li><a class="btn-floating yellow darken-1 tooltipped" data-position="left" data-delay="50" data-tooltip="Projekt erstellen">P</a></li>
        <li><a href="#newTicket" class="btn-floating red tooltipped modal-trigger" data-position="left" data-delay="50" data-tooltip="Ticket erstellen">T</a></li>
    </ul>
</div>

<!-- Modal Structure -->
<div id="newTicket" class="modal modal-fixed-footer">
    <form action="createTicket" method="post">
        <div class="modal-content">
            <h4>Neues Ticket erstellen</h4>
            <div class="row">

                <div class="input-field col s4">
                    <select name="projectCode">
                        <option value="" disabled selected>Bitte auswählen</option>
                        <c:forEach items="${applicationScope.projectList}" var="project">
                            <option value="${project.projectId}">${project.projectName}</option>
                        </c:forEach>
                    </select>
                    <label>Projekt</label>
                </div>
                <div class="input-field col s4">
                    <input name="ticketName" id="ticketName" type="text" >
                    <label for="ticketName">Thema</label>
                </div>
                <div class="input-field col s4">
                    <select name="priority">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3" selected>3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <label>Priorität</label>
                </div>
                <div class="input-field col s12">
                    <textarea name="description" id="description" type="text" class="materialize-textarea"></textarea>
                    <label for="description">Beschreibung</label>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <a href="#!" class=" modal-action modal-close waves-effect waves-red btn-flat">Abbrechen</a>
            <button type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Speichern</button>
        </div>
    </form>

</div>