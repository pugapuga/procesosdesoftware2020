package Task_board;

public class Issue {

    private String id;
    private String subject;
    private String description;
    public Board board;
    public SwimLane swimLane;

    public Issue(String id, String subject, String description, Board board, SwimLane swimLane) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.board = board;
        this.swimLane = swimLane;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public SwimLane getSwimLane() {
        return swimLane;
    }

    public void setSwimLane(SwimLane swimLane) {
        this.swimLane = swimLane;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", subject=" + subject + ", description=" + description + '}';
    }

}
