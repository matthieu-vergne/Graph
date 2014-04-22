package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import fr.vergne.graph.Hyperedge;

public class ImmutableHyperedge<VertexType> implements Hyperedge<VertexType> {

	private final Collection<VertexType> vertices;

	public ImmutableHyperedge(Collection<VertexType> vertices) {
		this.vertices = Collections
				.unmodifiableSet(new LinkedHashSet<VertexType>(vertices));
	}

	public Collection<VertexType> getVertices() {
		return vertices;
	}

	public boolean hasSameVerticesThan(Hyperedge<?> r) {
		return getVertices().containsAll(r.getVertices())
				&& r.getVertices().containsAll(getVertices());
	}

	@Override
	public String toString() {
		return getVertices().toString();
	}
}
