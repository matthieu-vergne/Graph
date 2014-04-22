package fr.vergne.graph;

public interface Graph<CVertex, CLink extends Edge<? extends CVertex>> extends
		Hypergraph<CVertex, CLink> {

}
