package fr.vergne.graph;

public interface Arc<CVertex> extends Edge<CVertex> {

	public CVertex getStart();

	public CVertex getStop();
}
