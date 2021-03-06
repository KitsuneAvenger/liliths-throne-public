package com.lilithsthrone.game.dialogue.encounters;

import com.lilithsthrone.game.dialogue.DebugDialogue;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.main.Main;

/**
 * @since 0.2.1
 * @version 0.2.1
 * @author Innoxia
 */
public class SubmissionEncounterDialogue {

	public static final DialogueNodeOld ALLEY_FIND_ITEM = new DialogueNodeOld("Rubbish Pile", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "TODO Find an item in rubbish pile:"//TODO
					+ "</p>"
					+ "<p style='text-align:center;'>"
						+ "<b>"
						+ Encounter.getRandomItem().getDisplayName(true)
						+ "</b>"
					+ "</p>";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Take", "Add the " + Encounter.getRandomItem().getName() + " to your inventory.", DebugDialogue.getDefaultDialogueNoEncounter()){
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(Main.game.getPlayer().addItem(Encounter.getRandomItem(), true, true));
					}
				};
				
			} else if (index == 2) {
				return new Response("Leave", "Leave the " + Encounter.getRandomItem().getName() + " on the floor.", DebugDialogue.getDefaultDialogueNoEncounter());
				
			} else {
				return null;
			}
		}
	};
}
