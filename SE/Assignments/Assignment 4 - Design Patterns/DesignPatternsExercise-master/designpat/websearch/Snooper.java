package designpat.websearch;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
/**
 * Watches the search queries
 */
public class Snooper {
    private final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("Oh yes! " + query);
            }
        }, new WebSearchModel.QueryFilter() {
            @Override
            public boolean accepted(String context) {
                return context.toLowerCase().contains("friend");
            }
        });

        model.addQueryObserver(new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("So long....! " + query);
            }
        }, new WebSearchModel.QueryFilter() {
            @Override
            public boolean accepted(String context) {
                return context.length() > 60;
            }
        });



    }
}
