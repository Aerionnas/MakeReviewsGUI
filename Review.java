public class Review {

  private int team;
  private int rating;
  private String reviewer;
  private String comment;

  public Review(int team, int rating, String reviewer, String comment) {

      this.team = team;
      this.rating = rating;
      this.comment = comment;
      this.reviewer = reviewer;

  }

  public int getTeam() {
    return this.team;
  }

  public int getRating() {
    return this.rating;
  }

  public String getReviewer() {
    return this.reviewer;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String a) {
    this.comment = a;
  }

  public void setRating(int a) {
    this.rating = a;
  }

  public String toString() {
    return "* Team:" + getTeam() + "| Rating:" + getRating() + "| Reviewer" + getReviewer() + "| Comments:" + getComment();
  }

  public static void main(String[] args) {
    Review first = new Review(1, 10, "Steven", "Good!");
    Review second = new Review(4, 1, "aeri", "You suck!");

    System.out.println(first.toString());
    System.out.println(second.toString());
  }
}
