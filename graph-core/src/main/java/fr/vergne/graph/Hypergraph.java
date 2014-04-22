package fr.vergne.graph;

import java.util.Collection;

public interface Hypergraph<CVertex, CHyperedge extends Hyperedge<? extends CVertex>> {

	public Collection<CVertex> getVertices();

	public Collection<CHyperedge> getEdges();
}
