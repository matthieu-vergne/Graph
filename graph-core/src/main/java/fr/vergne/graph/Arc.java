package fr.vergne.graph;

public interface Arc<VertexType> extends Edge<VertexType> {

	public VertexType getStart();

	public VertexType getStop();
}
