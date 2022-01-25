-- type insert
INSERT INTO types (type_id, type_name) VALUES (1, "admin");
INSERT INTO types (type_id, type_name) VALUES (2, "stagiaire");

-- user insert
INSERT INTO users (user_id, user_name, user_password, user_type_id) 
VALUES (1, "admin1", "azerty123", 1);

INSERT INTO users (user_id, user_name, user_password, user_societe, user_type_id) 
VALUES (2, "Vincent Rambaud", "azerty123123!", "sogeti", 2);

-- qcm insert
INSERT INTO qcm (qcm_id, qcm_author, qcm_description, qcm_name)
VAlUES (1212, "admin1", "", "JAVA");

-- question insert
INSERT INTO questions (q_id, q_ennonce) 
VAlUES (1, "soit l'appel suivant : public static void main(String[]args){ afficher(1); afficher(1,2); } Choisir la (les) bonne(s) signature(s) de la méthode afficher :");

INSERT INTO question_responses (question_q_id, response_text, response_value)
VAlUES (1, "static void afficher(int... param)", 1);
INSERT INTO question_responses (question_q_id, response_text, response_value)
VAlUES (1, "static void afficher(int x, int.... param)", 1);
INSERT INTO question_responses (question_q_id, response_text, response_value)
VAlUES (1, "static void afficher(int[] param)", 0);

INSERT INTO qcm_qcm_question (qcm_qcm_id, qcm_question_q_id)
VAlUES (1212, 1);

-- parcours insert
INSERT INTO parcour (parcour_id, parcour_date, parcour_time, parcour_note, parcour_nb_succes, parcour_nb_failed, parcour_qcm_id, parcour_stagiaire_id)
VALUES (1, "2022-01-24", 1235.256, "20/20", 1, 0, 1212, 2);

INSERT INTO p_parcours_question_link (parcour_id, q_id)
VALUES (1,1);