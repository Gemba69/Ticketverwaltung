
<!-- NewTicketModal -->
<div id="newTicket" class="modal modal-fixed-footer">
    <form action="CreateTicket" method="post" accept-charset="UTF-8">
        <div class="modal-content">
            <h4>Neues Ticket erstellen</h4>
            <div class="row">

                <div class="input-field col s4">
                    <select name="projectCode">
                        <option value="" disabled selected>Bitte auswählen</option>
                        <c:forEach items="${applicationScope.projectList}" var="project">
                            <option value="${project.projectCode}">${project.projectName}</option>
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