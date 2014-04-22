package fr.vergne.graph;

public interface Edge<VertexType> extends Hyperedge<VertexType> {

	VertexType getVertex1();

	VertexType getVertex2();
}
