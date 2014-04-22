package fr.vergne.graph;

import java.util.Collection;

public interface Hypergraph<VertexType, EdgeType extends Hyperedge<? extends VertexType>> {

	public Collection<VertexType> getVertices();

	public Collection<EdgeType> getEdges();
}
