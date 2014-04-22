package fr.vergne.graph;

import java.util.Iterator;

/**
 * We speak here about a tree as considered in computer science (connected,
 * acyclic, directed graph with a single root), not a mathematical one
 * (connected acyclic graph).
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 * @param <VertexType>
 */
public interface Tree<VertexType, ArcType extends Arc<? extends VertexType>> extends Graph<VertexType, ArcType> {

	public VertexType getRoot();

	public ChildrenIterator<VertexType> getChildrenOf(VertexType vertex);

	public static interface ChildrenIterator<VertexType> extends
			Iterator<VertexType>, Iterable<VertexType> {

	}
}
