package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import fr.vergne.graph.Hyperedge;
import fr.vergne.graph.Hypergraph;

public class ImmutableHypergraph<CVertex, CHyperedge extends Hyperedge<? extends CVertex>>
		implements Hypergraph<CVertex, CHyperedge> {

	private final Collection<CVertex> vertices;
	private final Collection<CHyperedge> edges;

	public ImmutableHypergraph(Collection<? extends CVertex> vertices,
			Collection<? extends CHyperedge> edges) {
		this.vertices = Collections.unmodifiableSet(new LinkedHashSet<CVertex>(
				vertices));
		this.edges = Collections.unmodifiableSet(new LinkedHashSet<CHyperedge>(
				edges));
	}

	public Collection<CVertex> getVertices() {
		return vertices;
	}

	public Collection<CHyperedge> getEdges() {
		return edges;
	}
}
